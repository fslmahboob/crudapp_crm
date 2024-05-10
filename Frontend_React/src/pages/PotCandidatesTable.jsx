import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material'
import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';


const TablePage = () => {
    const [potcandidates, setPotcandidates] = useState([])

    useEffect(() => {
        loadPotcandidates()
    }, [])

    const loadPotcandidates = () => {
        const endpoint = "http://localhost:8080/potcandidates/getall"
        axios.get(endpoint)
             .then(response => setPotcandidates(response.data))
             .catch(error => console.log(error))
    }

    // function updatePotcandidates(id) {
    //     const endpoint = `http://localhost:8080/updatepotcandidates/${id}`;
    //     axios.put(endpoint)
    //          .then(response => {
    //              // Optionally, you can handle the response here if needed
    //              history.push(`/updatepotcandidates/${id}`);
    //          })
    //          .catch(error => {
    //              console.log(error);
    //              // Optionally, you can handle errors here
    //          });
    // }
    

    return (
        <div>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell align="right">Candidate ID</TableCell>
                            <TableCell align="right">Job ID</TableCell>
                            <TableCell align="right">First Name</TableCell>
                            <TableCell align="right">Last Name</TableCell>
                            <TableCell align="right">Mobile Number</TableCell>
                            <TableCell align="right">Email</TableCell>
                            <TableCell align="right">City</TableCell>
                            <TableCell align="right">Country</TableCell>
                            <TableCell align="right">Training End Date</TableCell>
                            <TableCell align="right">Actions</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {potcandidates.map((row) => (
                            <TableRow key={row.id} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                                {/* <TableCell component="th" scope="row">{row.id}</TableCell> */}
                                <TableCell align="right">{row.candidate_id}</TableCell>
                                <TableCell align="right">{row.job_id}</TableCell>
                                <TableCell align="right">{row.first_name}</TableCell>
                                <TableCell align="right">{row.last_name}</TableCell>
                                <TableCell align="right">{row.mobile}</TableCell>
                                <TableCell align="right">{row.email}</TableCell>
                                <TableCell align="right">{row.city}</TableCell>
                                <TableCell align="right">{row.country}</TableCell>
                                <TableCell align="right">{row.trainingenddate}</TableCell>
                                <TableCell align="right">
                                    <Link className='btn-update'
                                    to={`/updatepotcandidates/${row.candidate_id}`}
                                    >Update</Link>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
            {/* <Link to={"/"+username}>Home</Link> */}
            <Link to="/home">Home</Link>
        </div>
    )
}

export default TablePage
