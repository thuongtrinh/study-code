
function ComponentCha(props) {
  //Hàm này sẽ được gọi khi nhận được dữ liệu
  const receiveData = function (data) {
    console.log("Data nhận được", data);
    alert("Data nhận được")
  };
  //Gọi compoennt con và truyền vào một props có giá trị là một hàm
  return <ComponentCon onReceiveData={receiveData} />;
}

function ComponentCon(props) {
  return (
    <div>
      <button
        onClick={() => {
          // Chúng ta sẽ gọi props có tên là receiveData đã được truyền từ compoentCha. Và truyền vào đó giá trị cần gửi
          props.onReceiveData("data gửi đi");
        }}
      >
        Gửi lại cho componentCha
      </button>
    </div>
  );
}

export default ComponentCha;
