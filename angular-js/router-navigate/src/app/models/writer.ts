import { BookDetail } from './bookDetail';

export interface Writer {
   writerId: number;
   writerName: string;
   bookDetails: BookDetail[];
}
