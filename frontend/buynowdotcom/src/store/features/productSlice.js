import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { api } from '../../component/services/api';

export const getAllProducts = createAsyncThunk(
    'product/getAllProducts',
    async () => {
        const response = await api.get('/products/all');
        return response.data.data;
    }
);

const initialState = {
    products: [],
    errorMessage: null,
    isLoading: true,
}

const productSlice = createSlice({
    name: 'product',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(getAllProducts.fulfilled, (state, action) => {
                state.products = action.payload;
                state.errorMessage = null;
                state.isLoading = false;
            })
    }
});

export const { } = productSlice.actions

export default productSlice.reducer