import { useEffect } from "react";
import { useLocation } from "react-router-dom";

function ScrollToTop() {
  const location = useLocation();

  useEffect(() => {
    window.scrollTo(10, 10);
  }, [location.pathname]);

  return null;
}

export default ScrollToTop;
