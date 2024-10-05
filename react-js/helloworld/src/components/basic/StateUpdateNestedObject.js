import { useState } from "react";

export default function StateUpdateNestedObject() {
  const [person, setPerson] = useState({
    name: "Alice",
    address: {
      street: "123 Main St",
      city: "New York",
    },
  });

  const updateCity = (newCity) => {
    // Tạo một bản sao của đối tượng address và chỉ cập nhật thành phố
    const updatedAddress = { ...person.address, city: newCity };
    // Tạo một bản sao mới của đối tượng person và cập nhật đối tượng address
    const updatedPerson = { ...person, address: updatedAddress };
    setPerson(updatedPerson);
  };

  return (
    <div>
      <h3>Xử lý đối tượng lồng ghép (Nested Objects)</h3>
      <p>Tên: {person.name}</p>
      <p>
        Địa chỉ: {person.address.street}, {person.address.city}
      </p>
      <button onClick={() => updateCity("Los Angeles")}>
        Đổi thành phố thành Los Angeles
      </button>
    </div>
  );
}
