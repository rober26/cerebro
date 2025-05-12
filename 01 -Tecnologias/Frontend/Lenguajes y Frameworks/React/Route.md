###  1. Instalación

`npm install react-router-dom`

---

### 2. Estructura básica
```
import { BrowserRouter, Routes, Route } from 'react-router-dom'; import Home from './pages/Home'; 
import About from './pages/About';  
function App() {   
	return (     
		<BrowserRouter>       
			<Routes>         
				<Route path="/" element={<Home />} />         
				<Route path="/about" element={<About />} />  
			</Routes>     
		</BrowserRouter>   
	); 
}
```


---

### 3. Navegación entre rutas

####  Enlaces
```
import { Link } from 'react-router-dom';  
<Link to="/">Inicio</Link> 
<Link to="/about">Acerca de</Link>
```

####  Navegación programática
```
import { useNavigate } from 'react-router-dom';  
const navigate = useNavigate(); 
navigate('/about');
```


---

###  4. Rutas anidadas
```
<Route path="/dashboard" element={<Dashboard />}>   
<Route path="profile" element={<Profile />} />   
<Route path="settings" element={<Settings />} /> 
</Route>
```

En `Dashboard.jsx`, debes tener:

`<Outlet />`

---

###  5. Ruta 404 (No Match)

`<Route path="*" element={<NotFound />} />`

---

###  6. Parámetros en la URL

#### Ruta con parámetro

`<Route path="/user/:id" element={<User />} />`

#### Acceder al parámetro
```
import { useParams } from 'react-router-dom';  
const { id } = useParams();
```


---

###  7. Redirección
```
import { Navigate } from 'react-router-dom';  
<Route path="/old-route" element={<Navigate to="/new-route" />} />
```

---

###  8. Rutas protegidas (ejemplo simple)
```
const ProtectedRoute = ({ isAuthenticated, children }) => {   
	return isAuthenticated ? children : <Navigate to="/login" />; 
};  

<Route path="/dashboard" element={   
	<ProtectedRoute isAuthenticated={userLoggedIn}>     
	<Dashboard />   
	</ProtectedRoute> 
} />
```

