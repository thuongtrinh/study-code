import { useState, useEffect } from "react";

function useOnlineStatus() {
  const [isOnline, setIsOnline] = useState(true);

  useEffect(() => {
    function handleOnline() {
      console.log("handleOnline");
      setIsOnline(true);
    }

    function handleOffline() {
      console.log("handleOffline");
      setIsOnline(false);
    }

    window.addEventListener("online", handleOnline);
    window.addEventListener("offline", handleOffline);

    return () => {
      console.log("return useEffect ");
      window.removeEventListener("online", handleOnline);
      window.removeEventListener("offline", handleOffline);
    };
  }, []);

  return isOnline;
}

function StatusBar() {
  const isOnline = useOnlineStatus();
  return <h1>{isOnline ? "✅ Trực Tuyến" : "❌ Ngắt Kết Nối"}</h1>;
}

function SaveButton() {
  const isOnline = useOnlineStatus();

  function handleSaveClick() {
    console.log("✅ Tiến trình đã được lưu");
  }

  return (
    <button disabled={!isOnline} onClick={handleSaveClick}>
      {isOnline ? "Lưu tiến trình" : "Đang kết nối..."}
    </button>
  );
}

export default function CustomHooksUseOnlineStatus() {
  return (
    <>
      <h3>Custom Hooks trong ReactJS: useOnlineStatus</h3>
      <StatusBar />
      <SaveButton />
    </>
  );
}
