import routers from '@/routers/routers';
import { Suspense } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { ToastProvider } from '@/contexts/ToastProvider';
import { StoreUserProvider } from '@/contexts/StoreUserProvider';
import { SidebarProvider } from '@/contexts/SideBarProvider';
import SideBar from '@components/Sidebar/Sidebar';

function App() {
    return (
        <StoreUserProvider>
            <ToastProvider>
                <SidebarProvider>
                    <BrowserRouter>
                        <SideBar />
                        <Suspense fallback={<div>Loading...</div>}>
                            <Routes>
                                {routers.map((item, index) => {
                                    return (
                                        <Route
                                            path={item.path}
                                            element={<item.component />}
                                            key={index}
                                        />
                                    );
                                })}
                            </Routes>
                        </Suspense>
                    </BrowserRouter>
                </SidebarProvider>
            </ToastProvider>
        </StoreUserProvider>
    );
}

export default App;
