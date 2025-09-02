import { useEffect, useState } from 'react';

export const ProductImage = ({ productId }) => {
    const [productImg, setProductImg] = useState(null);

    useEffect(() => {
        const fetchProductImage = async (id) => {
            try {
                const response = await fetch(
                    `http://localhost:8080/api/v1/images/image/download/${id}`
                );
                const bolb = await response.blob();
                const reader = new FileReader();
                reader.onloadend = () => {
                    setProductImg(reader.result);
                };
                reader.readAsDataURL(bolb);
            } catch (error) {
                console.error("Error fetching image:", error);
            }
        };

        if (productId) {
            fetchProductImage(productId);
        }
    }, [productId]);

    if (!productImg) {
        return null;
    }


    return (
        <div>
            <img src={productImg} alt="Product Image" />
        </div>
    );
};

export default ProductImage;