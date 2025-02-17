// src/components/Sidebar.js - not using yet
import React, { useState } from 'react';
import {
    Drawer,
    List,
    ListItem,
    ListItemButton,
    ListItemText,
    Collapse,
} from '@mui/material';
import { ExpandLess, ExpandMore } from '@mui/icons-material';
import { Link } from 'react-router-dom';

const drawerWidth = 240;

const Sidebar = () => {
    const [openApplications, setOpenApplications] = useState(false);
    const handleApplicationsClick = () => setOpenApplications((prev) => !prev);

    return (
        <Drawer
            variant="permanent"
            anchor="left"
            sx={{
                width: drawerWidth,
                flexShrink: 0,
                '& .MuiDrawer-paper': { width: drawerWidth, boxSizing: 'border-box' },
            }}
        >
            <List>
                <ListItem disablePadding component={Link} to="/dashboard">
                    <ListItemButton>
                        <ListItemText primary="Dashboard" />
                    </ListItemButton>
                </ListItem>
                <ListItem disablePadding component={Link} to="/students">
                    <ListItemButton>
                        <ListItemText primary="Students" />
                    </ListItemButton>
                </ListItem>
                <ListItem disablePadding component={Link} to="/teachers">
                    <ListItemButton>
                        <ListItemText primary="Teachers" />
                    </ListItemButton>
                </ListItem>
                <ListItem disablePadding button onClick={handleApplicationsClick}>
                    <ListItemButton>
                        <ListItemText primary="Applications" />
                        {openApplications ? <ExpandLess /> : <ExpandMore />}
                    </ListItemButton>
                </ListItem>
                <Collapse in={openApplications} timeout="auto" unmountOnExit>
                    <List component="div" disablePadding>
                        {['I539', 'DS20', 'J1', 'M1'].map((form) => (
                            <ListItem key={form} disablePadding component={Link} to={`/applications/${form.toLowerCase()}`}>
                                <ListItemButton sx={{ pl: 4 }}>
                                    <ListItemText primary={form} />
                                </ListItemButton>
                            </ListItem>
                        ))}
                    </List>
                </Collapse>
            </List>
        </Drawer>
    );
};

export default Sidebar;
