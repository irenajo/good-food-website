export const RESTAURANTS = [
    {
      name: 'Restaurant A',
      address: '123 Main St',
      type: 'Chinese',
      waiters: [
        { firstName: 'John', lastName: 'Doe' },
        { firstName: 'Jane', lastName: 'Doe' }
      ]
    },
    {
      name: 'Restaurant B',
      address: '456 Elm St',
      type: 'Indian',
      waiters: [
        { firstName: 'Jim', lastName: 'Beam' },
        { firstName: 'Jack', lastName: 'Daniels' }
      ]
    }
  ];
  
  export const STATS = {
    totalRestaurants: 2,
    totalGuests: 100,
    reservations: {
      last24Hours: 5,
      last7Days: 20,
      last30Days: 50
    }
  };
  