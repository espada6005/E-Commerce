import { configureStore } from "@reduxjs/toolkit";
import searchReducer from "./features/searchSlice";
import categoryReducer from './features/categorySlice';
import productReducer from './features/productSlice';

export const store = configureStore({
    reducer: {
        search : searchReducer,
        category: categoryReducer,
        product: productReducer,
    }
})