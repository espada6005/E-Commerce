import { useState } from 'react'
import HeroSlider from './HeroSlider';
import SearchBar from '../search/SearchBar';
import { useDispatch } from 'react-redux';

const Hero = () => {
    const [currentSlide] = useState(0);
    return (
        <div className='hero'>
            <HeroSlider setCurrentSlide={currentSlide} />
            <div className='hero-content'>
                <h1>
                    Welcome to<span className='text-primary'>buyNow</span>.com
                </h1>
                <SearchBar />
                <div className='home-button-container'>
                    <a href='#' className='home-shop-button link'>
                        Shop Now
                    </a>
                    <button className='deals-button'>Today's Deals</button>
                </div>
            </div>
        </div>
    );
};

export default Hero