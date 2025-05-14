import { useState } from "react";

let initialShapes = [
  { id: 0, type: "circle", x: 50, y: 100 },
  { id: 1, type: "square", x: 150, y: 100 },
  { id: 2, type: "circle", x: 250, y: 100 },
];

export default function StateShapeEditorWithArray() {
  const [shapes, setShapes] = useState(initialShapes);

  function handleClick() {
    const nextShapes = shapes.map((shape) => {
      if (shape.type === "square") {
        // Không thay đổi
        return shape;
      } else {
        // Trả về một hình tròn mới 50 pixel bên dưới
        return {
          ...shape,
          y: shape.y + 50,
        };
      }
    });
    // Render lại với mảng mới
    setShapes(nextShapes);
  }

  return (
    <>
      <h3>Biến đổi mảng trong state</h3>
      <button onClick={handleClick}>Di chuyển hình tròn xuống!</button>
      {shapes.map((shape, index) => (
        <p key={index}>{shape.id + ", " + shape.type + ", " + shape.x + ", " + shape.y}</p>
      ))}
    </>
  );
}
