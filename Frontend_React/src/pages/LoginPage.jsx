import { TextField } from '@mui/material'
import axios from 'axios'
import React from 'react'
import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

const LoginPage = (props) => {

    const [firstname, setFirstname] = props.firstname
    const [password, setPassword] = props.password
    // Needed at the top of every page ("passing bearer token around")
    const [bearer, setBearer] = props.bearer

    // For navigation
    const navigate = useNavigate()

    const submitHandler = (e) => {
        e.preventDefault()
        // POST request to login
        const endpoint = "http://localhost:8080/soloproject2/auth/login"
        const requestBody = {}
        const requestOptions = {
            auth:{
                username: firstname,
                password: password
            }
        }
        axios.post(endpoint, {}, requestOptions)
             .then(response=>{
                console.log("Login Success!")
                setBearer("Bearer "+response.data)
                navigate("/potcandidates")})
             .catch(error=>console.log(error))
    }

  return (
    <div>
        <form onSubmit={submitHandler}>
            {/* Username: <input type="text" name="Username" value={username} onChange={e=>setUsername(e.target.value)}/>
            Password: <input type="text" name="Password" value={pw} onChange={e=>setPw(e.target.value)}/> */}
            <TextField id="firstname" label="Firstname" variant="outlined" value={firstname} onChange={e=>setFirstname(e.target.value)} />
            <TextField id="password" label="Password" variant="outlined" value={password} onChange={e=>setPassword(e.target.value)}/>
            <button type="submit">Submit</button>
        </form>
        <Link to="/register">Register User</Link>
        <p></p>
        <Link to="/">Back to Home</Link>
    </div>
  )
}

export default LoginPage
