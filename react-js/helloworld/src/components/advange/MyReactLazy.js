import { Suspense, lazy } from "react";

const MyComponent = lazy(() => import("./MyShouldComponentUpdate"));

function MyReactLazy() {
  return (
    <div>
      <p>React.lazy()</p>
      <Suspense fallback={<div>Loading...</div>}>
        <MyComponent />
      </Suspense>
    </div>
  );
}

export default MyReactLazy;
