const wrapper = document.getElementById("signature-pad");
const clearButton = wrapper.querySelector("[data-action=clear]");
const changeColorButton = wrapper.querySelector("[data-action=change-color]");
const undoButton = wrapper.querySelector("[data-action=undo]");
const updateButton = wrapper.querySelector("[data-action=update]");	// 22.06.27 수정 버튼 추가
const savePNGButton = wrapper.querySelector("[data-action=save-png]");
const saveJPGButton = wrapper.querySelector("[data-action=save-jpg]");
const saveSVGButton = wrapper.querySelector("[data-action=save-svg]");
const canvas = wrapper.querySelector("canvas");
const signaturePad = new SignaturePad(canvas, {
  // It's Necessary to use an opaque color when saving image as JPEG;
  // this option can be omitted if only saving as PNG or SVG
  backgroundColor: 'rgb(255, 255, 255)'
});

// Adjust canvas coordinate space taking into account pixel ratio,
// to make it look crisp on mobile devices.
// This also causes canvas to be cleared.
function resizeCanvas() {
  // When zoomed out to less than 100%, for some very strange reason,
  // some browsers report devicePixelRatio as less than 1
  // and only part of the canvas is cleared then.
  const ratio =  Math.max(window.devicePixelRatio || 1, 1);

  // This part causes the canvas to be cleared
  canvas.width = canvas.offsetWidth * ratio;
  canvas.height = canvas.offsetHeight * ratio;
  canvas.getContext("2d").scale(ratio, ratio);

  // This library does not listen for canvas changes, so after the canvas is automatically
  // cleared by the browser, SignaturePad#isEmpty might still return false, even though the
  // canvas looks empty, because the internal data of this library wasn't cleared. To make sure
  // that the state of this library is consistent with visual state of the canvas, you
  // have to clear it manually.
  signaturePad.clear(); // 리사이징 되면 canvas 자동 삭제되어 수동 삭제 처리하는 것으로 보임.
  
  // 저장된 사인값이 있다면 사인 영역에 값을 추가
  if($("#strUserSign").val() != ""){
  	signaturePad.fromDataURL($("#strUserSign").val());
  }
}

// On mobile devices it might make more sense to listen to orientation change,
// rather than window resize events.
window.onresize = resizeCanvas;
resizeCanvas();

function download(dataURL, filename) {
  const blob = dataURLToBlob(dataURL);
  const url = window.URL.createObjectURL(blob);

  const a = document.createElement("a");
  a.style = "display: none";
  a.href = url;
  a.download = filename;

  document.body.appendChild(a);
  a.click();

  window.URL.revokeObjectURL(url);
}

// One could simply use Canvas#toBlob method instead, but it's just to show
// that it can be done using result of SignaturePad#toDataURL.
function dataURLToBlob(dataURL) {
  // Code taken from https://github.com/ebidel/filer.js
  const parts = dataURL.split(';base64,');
  const contentType = parts[0].split(":")[1];
  const raw = window.atob(parts[1]);
  const rawLength = raw.length;
  const uInt8Array = new Uint8Array(rawLength);

  for (let i = 0; i < rawLength; ++i) {
    uInt8Array[i] = raw.charCodeAt(i);
  }

  return new Blob([uInt8Array], { type: contentType });
}

// SVG 데이터를 base64 디코딩
function getSvgData(dataURL){
	const parts = dataURL.split(';base64,');
	let raw = "";
	if(typeof parts[1] != "undefined"){
		raw = window.atob(parts[1]);
	}else{
		raw = dataURL;
	}
	return raw;
}

clearButton.addEventListener("click", () => {
  signaturePad.clear();
  $("#strUserSign").val("");
});

undoButton.addEventListener("click", () => {
  const data = signaturePad.toData();

  if (data) {
    data.pop(); // remove the last dot or line
    signaturePad.fromData(data);
  }
  
  // 포인트 값이 있는지 확인하여 없으면 저장되었던 사인 값 삭제
  const data2 = signaturePad.toData();
  if(data2==""){
	  $("#strUserSign").val("");
  }
});

// 수정 버튼 이벤트 추가
updateButton.addEventListener("click", () => {
	signaturePad.on();
	signaturePad.clear();
	$("#strUserSign").val("");
});

changeColorButton.addEventListener("click", () => {
  const r = Math.round(Math.random() * 255);
  const g = Math.round(Math.random() * 255);
  const b = Math.round(Math.random() * 255);
  const color = "rgb(" + r + "," + g + "," + b +")";

  signaturePad.penColor = color;
});

savePNGButton.addEventListener("click", () => {
  if (signaturePad.isEmpty()) {
    alert("Please provide a signature first.");
  } else {
    const dataURL = signaturePad.toDataURL();
    download(dataURL, "signature.png");
  }
});

saveJPGButton.addEventListener("click", () => {
  if (signaturePad.isEmpty()) {
    alert("Please provide a signature first.");
  } else {
    const dataURL = signaturePad.toDataURL("image/jpeg");
    download(dataURL, "signature.jpg");
  }
});

saveSVGButton.addEventListener("click", () => {
  if (signaturePad.isEmpty()) {
    alert("Please provide a signature first.");
  } else {
    const dataURL = signaturePad.toDataURL('image/svg+xml');
    download(dataURL, "signature.svg");
  }
});