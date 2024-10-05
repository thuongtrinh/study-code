import { useState } from "react";

export default function UserProfileState() {
    // Khởi tạo một đối tượng user trong state
    const [user, setUser] = useState({
      name: "John Doe",
      age: 30,
      email: "johndoe@example.com",
    });
  
    const updateUserEmail = (newEmail) => {
      // Không nên thay đổi trạng thái đối tượng user trực tiếp
      // Tạo một bản sao mới và cập nhật state
      const updatedUser = { ...user, email: newEmail };
      setUser(updatedUser);
    };
  
    return (
      <div>
        <h3>useState trong Reactjs với object</h3>
        <p>Tên: {user.name}</p>
        <p>Tuổi: {user.age}</p>
        <p>Email: {user.email}</p>
        <button onClick={() => updateUserEmail("newemail@example.com")}>
          Đổi Email
        </button>
      </div>
    );
  }