import React from "react";

function AlertButton({ message, children }) {
  return <button onClick={() => alert(message)}>{children}</button>;
}

export default function EventAlertButton() {
  return (
    <div>
      <h3>Đọc props trong xử lý sự kiện trong Reactjs</h3>
      <AlertButton message="Bắt đầu phát!">Phát phim</AlertButton>
      <AlertButton message="Đang tải lên!">Tải lên hình ảnh</AlertButton>
    </div>
  );
}
