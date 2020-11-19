import { Producto } from './producto';
export class Categoria {
    idCategoria: number;
    categoria: string;
    subCategoria?: number;
    tieneSubCategoria?: boolean;
    productos?: Producto[];
}
