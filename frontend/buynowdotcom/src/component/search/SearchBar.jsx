import { useEffect } from 'react'
import { useDispatch } from 'react-redux';
import { useSelector } from 'react-redux'
import { getAllCategories } from '../../store/features/categorySlice';
import { setSearchQuery, setSelectedCategory, clearFilters } from '../../store/features/searchSlice';

const SearchBar = () => {
    const dispatch = useDispatch();
    const categories = useSelector((state) => state.category.categories);
    const { searchQuery, selectedCategory } = useSelector(state => state.search);

    const handleCategoryChange = (e) => {
        dispatch(setSelectedCategory(e.target.value));
    };

    const handleClearFilters = () => {
        dispatch(clearFilters());
    }

    const handleSearchQueryChange = (e) => {
        dispatch(setSearchQuery(e.target.value));
    }

    useEffect(() => {
        dispatch(getAllCategories());
    }, [dispatch]);

    return (
        <div className='search-bar input-group input-group-sm'>
            <select value={selectedCategory} onChange={handleCategoryChange} className='form-control-sm'>
                <option value='all'>All Category</option>
                {categories.map((category) => (
                    <option key={category.id} value={category.name}>
                        {category.name}
                    </option>
                ))}
            </select>
            <input type="text" value={searchQuery} onChange={handleSearchQueryChange} className='form-control-sm' placeholder='search for product(e.g. watch..)' />
            <button onClick={handleClearFilters} className='search-button'>Clear Filter</button>
        </div>
    );
};

export default SearchBar