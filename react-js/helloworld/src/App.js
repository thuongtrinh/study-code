import { BrowserRouter, Routes, Route} from 'react-router-dom';
import HomePage from './components/HomePage';
import Welcome from './components/basic/Welcome';
import LoginPage from './components/advange/LoginPage';

function App() {
  return (
    <div style={{margin: "10px 0px 5in"}}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<HomePage/>}>
              <Route path="welcome" element={<Welcome/>} />
              <Route path="login" element={<LoginPage/>} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
