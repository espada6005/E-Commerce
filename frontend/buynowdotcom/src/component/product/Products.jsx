import ProductCard from './ProductCard';
import SearchBar from '../search/SearchBar';

export const Products = () => {
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
                    <ProductCard />
                    <div className='pagination'>Pagination coming here...</div>
                </section>
            </div>
        </>
    );
};

export default Products;
