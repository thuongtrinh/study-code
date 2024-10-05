import { useEffect, useState } from "react";

function MyUseEffect() {
  const [data, setData] = useState(null);

  useEffect(() => {
    fetch("https://5ad9a2c854db9a0014e49280.mockapi.io/api/employees")
      .then((response) => response.json())
      .then((data) => setData(data))
      .catch((error) => console.error(error));
  }, []);

  return (
    <div>
      {data ? (
        <ul>
          {data.map((item) => (
            <li key={item.id}>{item.name}</li>
          ))}
        </ul>
      ) : (
        <p>useEffect: Loading data...</p>
      )}
    </div>
  );
}

export default MyUseEffect;