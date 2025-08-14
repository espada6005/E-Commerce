import React from 'react'
import { Outlet } from "react-router-dom"
import NavBar from './NavBar'

const RootLayout = () => {
    return (
        <main>
            <NavBar />
            <div>
                <Outlet />
            </div>
        </main>
    )
}

export default RootLayout