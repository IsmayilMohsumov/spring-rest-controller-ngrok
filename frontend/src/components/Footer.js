// src/components/Footer.js
import React from 'react';
import { Box, Typography } from '@mui/material';

const Footer = () => {
    return (
        <Box component="footer" sx={{ p: 2, textAlign: 'center', backgroundColor: '#f5f5f5' }}>
            <Typography variant="body2" color="textSecondary">
                © {new Date().getFullYear()} Developed by wedevloop.com
            </Typography>
        </Box>
    );
};

export default Footer;
