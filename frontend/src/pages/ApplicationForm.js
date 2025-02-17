// src/pages/ApplicationForm.js
import React, { useState } from 'react';
import { Box, TextField, Button, Typography } from '@mui/material';
import { useParams } from 'react-router-dom';
import api from '../api/axiosInstance';

const ApplicationForm = () => {
    const { form } = useParams();
    const [formData, setFormData] = useState({
        name: '',
        surname: '',
        email: '',
        age: '',
        homeAddress: '',
        universityApplied: '',
        budget: '',
        dateOfArrival: '',
        countryOfResidence: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prev) => ({ ...prev, [name]: value }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        api.post('/applications', formData)
            .then((response) => {
                console.log('Application submitted:', response.data);
            })
            .catch((error) => {
                console.error('Error submitting application:', error);
            });
    };

    return (
        <Box component="form" onSubmit={handleSubmit} sx={{ maxWidth: 600, mx: 'auto', p: 2 }}>
            <Typography variant="h6" gutterBottom>
                {form.toUpperCase()} Application
            </Typography>
            <TextField fullWidth margin="normal" label="Name" name="name" value={formData.name} onChange={handleChange} />
            <TextField fullWidth margin="normal" label="Surname" name="surname" value={formData.surname} onChange={handleChange} />
            <TextField fullWidth margin="normal" label="Email" name="email" type="email" value={formData.email} onChange={handleChange} />
            <TextField fullWidth margin="normal" label="Age" name="age" type="number" value={formData.age} onChange={handleChange} />
            <TextField fullWidth margin="normal" label="Home Address" name="homeAddress" value={formData.homeAddress} onChange={handleChange} />
            <TextField fullWidth margin="normal" label="University Applied" name="universityApplied" value={formData.universityApplied} onChange={handleChange} />
            <TextField fullWidth margin="normal" label="Budget" name="budget" type="number" value={formData.budget} onChange={handleChange} />
            <TextField fullWidth margin="normal" label="Date of Arrival" name="dateOfArrival" type="date" InputLabelProps={{ shrink: true }} value={formData.dateOfArrival} onChange={handleChange} />
            <TextField fullWidth margin="normal" label="Country of Residence" name="countryOfResidence" value={formData.countryOfResidence} onChange={handleChange} />
            <Button type="submit" variant="contained" color="primary" sx={{ mt: 2 }}>Submit</Button>
        </Box>
    );
};

export default ApplicationForm;
