import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    itemsPerPage: 10,
    totalItems: 0,
    currentPage: 1,
}

const paginationSlice = createSlice({
    name: 'pagination',
    initialState,
    reducers: {
        setImagesPerPage: (state, action) => {
            state.itemsPerPage = action.payload;
        },
        setTotalItems: (state, action) => {
            state.totalItems = action.payload;
        },
        setCurrentPage: (state, action) => {
            state.currentPage = action.payload;
        },
    }
});

export const { setImagesPerPage, setTotalItems, setCurrentPage } = paginationSlice.actions

export default paginationSlice.reducer