// src/pages/Dashboard.js
import React from 'react';
import { Box, Typography } from '@mui/material';

const Dashboard = () => {
    const baseUrl = process.env.REACT_APP_API_URL.replace(/\/+$/, '');
    const imageUrl = `${baseUrl}/api/images/we.jpg`;

    console.log('Using image URL:', imageUrl);

    return (
        <Box sx={{ p: 2 }}>
            <Typography variant="h4" gutterBottom>
                Dashboard
            </Typography>
            <Typography variant="body1" gutterBottom>
                This image is fetched from S3 via the backend.
            </Typography>
            <Box
                component="img"
                src={imageUrl}
                alt="S3 Image"
                sx={{ maxWidth: '100%', height: 'auto', border: '1px solid #ccc', p: 1 }}
            />
        </Box>
    );
};

export default Dashboard;
