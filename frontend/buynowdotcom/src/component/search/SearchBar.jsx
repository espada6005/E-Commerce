import React from 'react'

const SearchBar = () => {
    return (
        <div className='search-bar input-group input-group-sm'>
            <select className='form-control-sm'>
                <option value='all'>All Category</option>
                <option value='all'>Tabs</option>
                <option value='all'>Gadget</option>
            </select>
            <input type="text" className='form-control-sm' placeholder='search for product(e.g. watch..)' />
            <button className='search-button'>Clear Filter</button>
        </div>
    )
}

export default SearchBar