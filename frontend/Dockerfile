#Frontend
FROM node:20-alpine

WORKDIR /app

COPY package*.json ./

RUN npm install
RUN npm install tailwindcss @tailwindcss/postcss postcss --force


COPY . .

RUN npm run build

EXPOSE 4200

CMD ["npm", "start"]