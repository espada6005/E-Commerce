import React from 'react'
import { Outlet } from "react-router-dom"
import NavBar from './NavBar'
import Footer from './Footer'

const RootLayout = () => {
    return (
        <main>
            <NavBar />
            <div>
                <Outlet />
            </div>
            <Footer />
        </main>
    )
}

export default RootLayout