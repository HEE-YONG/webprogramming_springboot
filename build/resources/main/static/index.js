window.onload = function () {
  const bgm = document.getElementById("bgm"); // 노래 요소 선택

  // 노래 시작
  bgm.play();
};
//모달
document.addEventListener("DOMContentLoaded", function () {
  var main = document.querySelector(".main");
  var modalWrapper = document.querySelector(".modal-wrapper");
  var trigger = document.querySelector(".trigger");

  trigger.addEventListener("click", openmodal);

  var closeButton = document.querySelector(".btn-close");
  closeButton.addEventListener("click", function () {
    modalWrapper.classList.remove("open");

    main.classList.remove("blur-it");
  });
});
function openmodal(e) {
  var modalWrapper = document.querySelector(".modal-wrapper");
  var main = document.querySelector(".main");

  modalWrapper.classList.toggle("open");
  main.classList.toggle("blur-it");

  return false;
}
