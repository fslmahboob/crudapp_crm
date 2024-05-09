import * as React from 'react';
import { useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import axios from 'axios';
import { useNavigate } from "react-router-dom";

export default function PotCandidates() {
  const [job_id, setJob_id] = useState('');
  const [first_name, setFirst_name] = useState('');
  const [last_name, setLast_name] = useState('');
  const [mobile, setMobile] = useState('');
  const [email, setEmail] = useState('');
  const [city, setCity] = useState('');
  const [country, setCountry] = useState('');
  const [trainingenddate, settrainingenddate] = useState('');

  const [message, setMessage] = useState('');

  const navigate = useNavigate()

  const handleClick = (e) => {
    e.preventDefault();
    
    const endpoint = "http://localhost:8080/potcandidates/${id}"
    const requestBody = {
            job_id:job_id,
            first_name:first_name,
            last_name:last_name,
            mobile:mobile,
            email:email,
            city:city,
            country:country,
            trainingenddate:trainingenddate
    }
    // console.log(PotCandidate);
    axios.put(endpoint, requestBody)
    .then(response=>{
      setMessage((prevMessage) => (prevMessage === "" ? "Potential Candidate Added Updated" : prevMessage)); // Update based on previous state
      navigate("/potcandidates");
    })
    .catch(error => console.log(error));
    // .catch(error=>setMessage(error.response.data.message))
  };

  return (
    <Box
      component="form"
      sx={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center', // Center horizontally
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <h1> Update Potential Candidate </h1>
      <TextField
        id="job_id"
        label="PotCand_job_id"
        variant="filled"
        value={job_id}
        onChange={(e) => setJob_id(e.target.value)}
      />
      <TextField
        id="first_name"
        label="PotCand_first_name"
        variant="filled"
        value={first_name}
        onChange={(e) => setFirst_name(e.target.value)}
      />
      <TextField
        id="last_name"
        label="PotCand_last_name"
        variant="filled"
        value={last_name}
        onChange={(e) => setLast_name(e.target.value)}
      />
      <TextField
        id="mobile"
        label="PotCand_mobile"
        variant="filled"
        value={mobile}
        onChange={(e) => setMobile(e.target.value)}
      />
      <TextField
        id="email"
        label="PotCand_email"
        variant="filled"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <TextField
        id="city"
        label="PotCand_city"
        variant="filled"
        value={city}
        onChange={(e) => setCity(e.target.value)}
      />
      <TextField
        id="country"
        label="PotCand_country"
        variant="filled"
        value={country}
        onChange={(e) => setCountry(e.target.value)}
      />
      <TextField
        id="trainingenddate"
        label="PotCand_trainingenddate"
        variant="filled"
        value={trainingenddate}
        onChange={(e) => settrainingenddate(e.target.value)}
      />
      {message && <p>{message}</p>}
      {/* {message ? <p>{message}</p> : null} */}

      <Button variant="contained" color="secondary" onClick={handleClick}>Update Candidate</Button>
      <Button
        variant="contained"
        color="primary"
        onClick={() => navigate('/potcandidatestable')}
      >
        Go Back
      </Button>
    </Box>
  );
}
