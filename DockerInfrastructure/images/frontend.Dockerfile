
FROM node:18-alpine as build

WORKDIR /usr/src/app

## Kopiraj package.json i package-lock.json
COPY ./package*.json ./

# Instaliraj zavisnosti
RUN npm install

# Kopiraj celokupan FRONTEND PROJEKAT
COPY . /usr/src/app

# Izvrši build sa odgovarajućim okruženjem
RUN npm run build -- --configuration production

#Poenta pravljenja 2 stagea je da se smanji memorija zavrsnog image-a
#U prvom stage-u smo izbuildali ceo projekat, i ako bismo ovde koristili 1 stage,
#Memorija image-a bi bila 1.2gb (testirao sam)

#Dok ovako pravimo 2 stage, kopiramo samo DIST folder koji je izbuildovan
# i koji sluzi za pokretanje aplikacije.Memorija ce biti 300mb

FROM node:18-alpine

#Iako isti path imaju, ova 2 WORKDIR-a su razlicita, jer FROM pravi novi sloj
WORKDIR /usr/src/app

# # Kopiraj aplikaciju iz build faze
COPY --from=build /usr/src/app/dist /usr/src/app

# Izloži port 4200
EXPOSE 4200

# Instaliraj Angular CLI globalno
RUN npm install -g @angular/cli

# Pokreni Angular aplikaciju
#CMD ["ng", "serve","--configuration","production", "--host", "0.0.0.0", "--port", "4200"]
CMD ["ng", "serve", "--host", "0.0.0.0", "--port", "4200"]
