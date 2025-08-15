export interface Donation {
    id?: number;
    donorName: string;
    type: 'MONEY' | 'FOOD' | 'CLOTHES' | 'OTHER';
    quantity: number;
    date: string;
}