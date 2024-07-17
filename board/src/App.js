import "./App.css";
import { Link, Route, Routes } from "react-router-dom";
import BoardList from "./board/BoardList";
import BoardWrite from "./board/BoardWrite";
import BoardDetail from "./board/BoardDetail";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<BoardList />} />
        <Route path="/list" element={<BoardList />} />
        <Route path="/write" element={<BoardWrite />} />
        <Route path="/detail/:boardIdx" element={<BoardDetail />} />
      </Routes>
    </>
  );
}

export default App;
