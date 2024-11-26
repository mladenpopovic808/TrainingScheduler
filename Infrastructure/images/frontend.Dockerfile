# Stage 1: Compile and Build Angular codebase
FROM node:18-alpine as build

WORKDIR /usr/src/app

ARG ENV=production

# Kopiraj package.json i package-lock.json
COPY ./package*.json ./

# Instaliraj zavisnosti
RUN npm install

# Kopiraj celokupan src direktorijum
COPY . /usr/src/app



# Izvrši build sa odgovarajućim okruženjem
RUN npm run build -- --configuration $ENV

# Stage 2: Serve the app using Angular CLI's ng serve
FROM node:18-alpine

WORKDIR /usr/src/app

# Kopiraj aplikaciju iz build faze
COPY --from=build /usr/src/app /usr/src/app

# Izloži port 4200
EXPOSE 4200

# Instaliraj Angular CLI globalno
RUN npm install -g @angular/cli

# Pokreni Angular aplikaciju
CMD ["ng", "serve","--configuration","production", "--host", "0.0.0.0", "--port", "4200"]
