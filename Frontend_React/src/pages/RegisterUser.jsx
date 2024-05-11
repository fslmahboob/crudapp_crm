import { Alert, TextField } from '@mui/material'
import axios from 'axios'
import React from 'react'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'

const RegisterUser = () => {

    const [firstname, setFirstname] = useState("")
    const [password, setPassword] = useState("")

    const navigate = useNavigate()

    const submitHandler = (e) => {
        e.preventDefault()

        const endpoint = "http://localhost:8080/soloproject2/users/register"
        const requestBody = 
        {
            firstname:firstname,
            password:password,
            lastname: "lastname",
            email:"email",
            country:"country",
            city:"city",
        }

        axios.post(endpoint, requestBody)
             .then(response=>{
                navigate("/"+firstname)
             })
            //  .catch(error=>setMessage(error.response.data.message))
    }



  return (
    <div>
        <form onSubmit={submitHandler}>
            {/* Username: <input type="text" name="Username" value={username} onChange={e=>setUsername(e.target.value)}/>
            Password: <input type="text" name="Password" value={pw} onChange={e=>setPw(e.target.value)}/> */}
            <TextField id="firstname" label="Firstname" variant="outlined" value={firstname} onChange={e=>setFirstname(e.target.value)} />
            <TextField id="password" label="Password" variant="outlined" value={password} onChange={e=>setPassword(e.target.value)}/>
            {/* {message !== "" && <Alert severity="error">{message}</Alert>} */}
            <button type="submit">Submit</button>
        </form>
        <Link to="/">Back to Home</Link>
    </div>
  )
}

export default RegisterUser
