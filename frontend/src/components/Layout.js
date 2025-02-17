// src/components/Layout.js
import React from 'react';
import Header from './Header';
import Navbar from './Navbar';
import Footer from './Footer';
import { Container } from '@mui/material';

const Layout = ({ children }) => {
    return (
        <>
            <Header />
            <Navbar />
            <Container sx={{ mt: 2, mb: 2 }}>
                {children}
            </Container>
            <Footer />
        </>
    );
};

export default Layout;
