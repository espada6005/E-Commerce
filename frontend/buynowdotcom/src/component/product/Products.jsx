import ProductCard from './ProductCard';
import SearchBar from '../search/SearchBar';
import { useDispatch, useSelector } from 'react-redux'
import { useState, useEffect } from 'react';
import { getAllProducts } from '../../store/features/productSlice';

export const Products = () => {
    const [filteredProducts, setFilteredProducts] = useState([]);
    const dispatch = useDispatch();
    const products = useSelector((state) => state.product.products);
    const { searchQuery, selectedCategory } = useSelector((state) => state.search);

    useEffect(() => {
        dispatch(getAllProducts());
    }, [dispatch]);

    useEffect(() => {
        const results = products.filter((product) => {
            const matchesQuery = product.name
                .toLowerCase()
                .includes(searchQuery.toLowerCase());
            const matchesCategory = selectedCategory === "all" ||
                product.category.name
                    .toLowerCase()
                    .includes(selectedCategory.toLowerCase());
            return matchesQuery && matchesCategory;
        });
        setFilteredProducts(results);
    }, [products, selectedCategory, searchQuery]);

    return (
        <>
            <div className='d-flex justify-content-center'>
                <div className='col-md-6 mt-2'>
                    <div className='search-bar input-group'>
                        <SearchBar />
                    </div>
                </div>
            </div>

            <div className='d-flex'>
                <aside className='sidebar' style={{ width: '250px', padding: '1rem' }}>
                    Sidebar coming here...
                </aside>
                <section style={{ flex: 1 }}>
                    <ProductCard products={filteredProducts} />
                    <div className='pagination'>Pagination coming here...</div>
                </section>
            </div>
        </>
    );
};

export default Products;
