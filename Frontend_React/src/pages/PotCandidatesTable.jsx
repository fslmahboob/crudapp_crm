import { Button, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material'
import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';


const TablePage = (props) => {
    const [potcandidates, setPotcandidates] = useState([])

    // Needed at the top of every page ("passing bearer token around")
    const [bearer, setBearer] = props.bearer

    useEffect(() => {
        loadPotcandidates()
    }, [])

    const loadPotcandidates = () => {
        const endpoint = "http://localhost:8080/soloproject2/potcandidates/getall"
        const requestOptions = {
            headers:{
                "Authorization": bearer
            }
        }
        axios.get(endpoint, requestOptions)
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
    
    function removePotcandidates(candidate_id){
        //console.log(candidate_id);
        const endpoint = `http://localhost:8080/soloproject2/potcandidates/${candidate_id}`;
        const requestOptions = {
            headers:{
                "Authorization": bearer
            }
        }
        axios.delete(endpoint, requestOptions)
             .then(response => {
                loadPotcandidates()
             }).catch(error => {
                console.error(error);
             })
    }

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
                            <TableCell align="right">Actions</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {potcandidates.map((row) => (
                            <TableRow key={row.id} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                                {/* <TableCell component="th" scope="row">{row.id}</TableCell> */}
                                <TableCell align="right">{row.candidate_id}</TableCell>
                                <TableCell align="right">{row.jobid}</TableCell>
                                <TableCell align="right">{row.firstname}</TableCell>
                                <TableCell align="right">{row.lastname}</TableCell>
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
                                <TableCell align="right">
                                    <Button className='btn-del' onClick={() => removePotcandidates(row.candidate_id)}
                                    >Delete</Button>
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
