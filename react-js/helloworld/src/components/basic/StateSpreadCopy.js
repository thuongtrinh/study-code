import { useState } from "react";

export default function StateSpreadCopy() {
    const [person, setPerson] = useState({
      firstName: "John",
      lastName: "Doe",
      age: 30,
    });
  
    const updateFirstName = (newFirstName) => {
      // Tạo bản sao mới của đối tượng person và chỉ cập nhật firstName
      const updatedPerson = { ...person, firstName: newFirstName };
      setPerson(updatedPerson);
    };
  
    return (
      <div>
        <h3>Sử dụng toán tử Spread</h3>
        <p>Họ: {person.lastName}</p>
        <p>Tên: {person.firstName}</p>
        <p>Tuổi: {person.age}</p>
        <button onClick={() => updateFirstName("Alice")}>
          Đổi tên thành Alice
        </button>
      </div>
    );
  }