import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Appbar from './components/Appbar.jsx';
import PotCandidates from './pages/PotCandidates.jsx';
import PotCandidatesTable from './pages/PotCandidatesTable.jsx';
import UpdatePotCandidates from './pages/UpdatePotCandidates.jsx';
import Home from './pages/Home.jsx';
import {BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  // const [count, setCount] = useState(0)

  return (
    <>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/potcandidates" element={<PotCandidates />} />
          <Route path="/potcandidatestable" element={<PotCandidatesTable />} />
          <Route path="/updatepotcandidates/:candidate_id" element={<UpdatePotCandidates />} />
        </Routes>
      </div>
    </>
  )
}

export default App
