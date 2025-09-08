import { Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import ProductImage from '../utils/ProductImage';
import { useDispatch, useSelector } from 'react-redux'
import { useEffect } from 'react';
import { getAllProducts } from '../../store/features/productSlice';

const ProductCard = () => {
    const dispatch = useDispatch();
    const products = useSelector((state) => state.product.products);

    console.log(products);

    useEffect(() => {
        dispatch(getAllProducts());
    }, [dispatch]);

    return (
        <main className='row m-2'>
            {products.map((product) => (
                <div className='col-12 col-sm-6 col-md-4 col-lg-2' key={product.id}>
                    <Card className='mb-2 mt-2'>
                        <Link to={`/product/${product.id}/details`} className='link'>
                            <div className='image-container'>
                                {product.images.length > 0 && (
                                    <ProductImage productId={product.images[0].id} />
                                )}
                            </div>
                        </Link>
                        <Card.Body>
                            <p className='product-description'>
                                {product.name} - {product.description}
                            </p>
                            <h4 className='price'>${product.price}</h4>
                            <p className='text-success'>{product.inventory} in stock.</p>
                            <div className='d-flex gap-2'>
                                <button className='shop-now-button'>Add to cart</button>
                            </div>
                        </Card.Body>
                    </Card>
                </div>
            ))}
        </main>
    );
};

export default ProductCard;