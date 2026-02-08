import { useState } from "react";

let nextId = 3;
const initialArtists = [
  { id: 0, name: "Marta Colvin Andrade" },
  { id: 1, name: "Lamidi Olonade Fakeye" },
  { id: 2, name: "Louise Nevelson" },
];

export default function StateInsertArray() {
  const [name, setName] = useState("");
  const [artists, setArtists] = useState(initialArtists);

  function handleClick() {
    const insertAt = 1; // Có thể là bất kỳ chỉ mục nào
    const nextArtists = [
      // Các phần tử trước điểm chèn:
      ...artists.slice(0, insertAt),
      // Phần tử mới:
      { id: nextId++, name: name },
      // Các phần tử sau điểm chèn:
      ...artists.slice(insertAt),
    ];
    setArtists(nextArtists);
    setName("");
  }

  return (
    <>
      <h3>Chèn phần tử vào mảng trong state của React</h3>
      <p>Danh sách nghệ sĩ:</p>
      <input value={name} onChange={(e) => setName(e.target.value)} />
      <button onClick={handleClick}>Thêm</button>
      <ul>
        {artists.map((artist, index) => (
          // Render các nghệ sĩ ở đây
          <p key={index}>{artist.id + ", " + artist.name}</p>
        ))}
      </ul>
    </>
  );
}
