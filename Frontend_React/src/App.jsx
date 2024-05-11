import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Appbar from './components/Appbar.jsx';
import PotCandidates from './pages/PotCandidates.jsx';
import PotCandidatesTable from './pages/PotCandidatesTable.jsx';
import UpdatePotCandidates from './pages/UpdatePotCandidates.jsx';
import LoginPage from './pages/LoginPage.jsx';
import Home from './pages/Home.jsx';
import {BrowserRouter, Routes, Route } from 'react-router-dom';
import RegisterUser from './pages/RegisterUser.jsx';

function App() {
  // const [count, setCount] = useState(0)

  const [number, setNumber] = useState(0)
  const [firstname, setFirstname] = useState("")
  const [password, setPassword] = useState("")

  const [bearer, setBearer] = useState("")

  // Needed at the top of every page ("passing bearer token around")
  //const [bearer, setBearer] = props.bearer

  return (
    <>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/login" element={<LoginPage bearer={[bearer, setBearer]} firstname={[firstname,setFirstname]} password={[password, setPassword]}/>}/>
          {/* Put in bearer, setBearer similar to above in the page */}
          <Route path="/register" element={<RegisterUser bearer={[bearer, setBearer]} firstname={[firstname,setFirstname]} password={[password, setPassword]}/>}/>

          {/* <Route path="/:firstname"element={<User bearer={[bearer, setBearer]} firstname={[firstname,setFirstname]} password={[password, setPassword]}/>}/> */}

          <Route path="/potcandidates" element={<PotCandidates bearer={[bearer, setBearer]} firstname={[firstname,setFirstname]} password={[password, setPassword]} />} />
          <Route path="/potcandidatestable" element={<PotCandidatesTable bearer={[bearer, setBearer]} firstname={[firstname,setFirstname]} password={[password, setPassword]}/>} />
          <Route path="/updatepotcandidates/:candidate_id" element={<UpdatePotCandidates bearer={[bearer, setBearer]} firstname={[firstname,setFirstname]} password={[password, setPassword]} />} />
        </Routes>
      </div>
    </>
  )
}

export default App
