import { useState } from "react";

let initialArtists = [
  { id: 0, name: "Marta Colvin Andrade" },
  { id: 1, name: "Lamidi Olonade Fakeye" },
  { id: 2, name: "Louise Nevelson" },
];

export default function StateRemoveArray() {
  const [artists, setArtists] = useState(initialArtists);

  return (
    <>
      <h3>Xóa phần tử khỏi mảng trong state</h3>
      <p>Danh sách nghệ sĩ:</p>
      <ul>
        {artists.map((artist) => (
          <li key={artist.id}>
            {artist.name}{" "}
            <button
              onClick={() => {
                setArtists(artists.filter((a) => a.id !== artist.id));
              }}
            >
              Xóa
            </button>
          </li>
        ))}
      </ul>
    </>
  );
}
