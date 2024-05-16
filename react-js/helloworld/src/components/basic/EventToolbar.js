import React from "react";

function Button({ onClick, children }) {
  return <button onClick={onClick}>{children}</button>;
}

function PlayButton({ movieName }) {
  function handlePlayClick() {
    alert(`Bắt đầu phát "${movieName}"!`);
  }

  return <Button onClick={handlePlayClick}>Phát "${movieName}"</Button>;
}

function UploadButton() {
  return (
    <Button onClick={() => alert("Đang tải lên!")}>Tải lên hình ảnh</Button>
  );
}

export default function EventToolbar() {
  return (
    <div>
      <h3>Truyền xử lý sự kiện như props trong Reactjs</h3>
      <PlayButton movieName="Kiki's Delivery Service" />
      <UploadButton />
    </div>
  );
}
