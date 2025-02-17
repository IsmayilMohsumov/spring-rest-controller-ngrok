// src/components/Navbar.js
import React, { useState } from 'react';
import { AppBar, Toolbar, Button, Menu, MenuItem, Box } from '@mui/material';
import { Link } from 'react-router-dom';

const navItems = [
    { label: 'Dashboard', path: '/dashboard' },
    { label: 'Students', path: '/students' },
    { label: 'Teachers', path: '/teachers' },
    {
        label: 'Applications',
        submenu: [
            { label: 'I539', path: '/applications/i539' },
            { label: 'DS20', path: '/applications/ds20' },
            { label: 'J1', path: '/applications/j1' },
            { label: 'M1', path: '/applications/m1' },
        ]
    },
];

const Navbar = () => {
    const [anchorEl, setAnchorEl] = useState(null);

    const handleMenuOpen = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const handleMenuClose = () => {
        setAnchorEl(null);
    };

    return (
        <AppBar position="static" color="primary" sx={{ mb: 2 }}>
            <Toolbar>
                <Box sx={{ display: 'flex', flexGrow: 1 }}>
                    {navItems.map((item) => {
                        if (item.submenu) {
                            return (
                                <div key={item.label}>
                                    <Button
                                        color="inherit"
                                        onClick={handleMenuOpen}
                                    >
                                        {item.label}
                                    </Button>
                                    <Menu
                                        anchorEl={anchorEl}
                                        open={Boolean(anchorEl)}
                                        onClose={handleMenuClose}
                                        anchorOrigin={{ vertical: 'bottom', horizontal: 'left' }}
                                        transformOrigin={{ vertical: 'top', horizontal: 'left' }}
                                    >
                                        {item.submenu.map((subitem) => (
                                            <MenuItem
                                                key={subitem.label}
                                                component={Link}
                                                to={subitem.path}
                                                onClick={handleMenuClose}
                                            >
                                                {subitem.label}
                                            </MenuItem>
                                        ))}
                                    </Menu>
                                </div>
                            );
                        } else {
                            return (
                                <Button
                                    key={item.label}
                                    color="inherit"
                                    component={Link}
                                    to={item.path}
                                >
                                    {item.label}
                                </Button>
                            );
                        }
                    })}
                </Box>
            </Toolbar>
        </AppBar>
    );
};

export default Navbar;
