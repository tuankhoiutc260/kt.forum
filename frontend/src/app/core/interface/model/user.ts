import { Role } from "./role";

export interface User {
    id?: string;
    userName?: string;
    password?: string;
    email?: string;
    fullName?: string;
    active?: boolean;
    image?:string;
    createdDate?: Date | string;
    createdBy?: string;
    lastModifiedDate?: Date | string;
    lastModifiedBy?: string;
    role?: Role
}
